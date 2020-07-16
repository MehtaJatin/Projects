package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(origins = "http://localhost:9090")
public class MainController {
	
	@Autowired
	VenderRepository vr;
	
	@Autowired
	TenderRepository tr;
	
	@Autowired
	BidValueRepository br;
	
	@RequestMapping(path="/registerVender",
			        method=RequestMethod.POST,
			        consumes=MediaType.APPLICATION_JSON_VALUE,
			        produces=MediaType.APPLICATION_JSON_VALUE
			       )
	public ResponseEntity<StringResult> venderregister(@RequestBody VenderInfo v)
	{
	
		vr.save(v);
		return new ResponseEntity<StringResult>(new StringResult(v.getName()),HttpStatus.CREATED);
		
	}
	

	 
	@RequestMapping(path="/registerTender",
	        method=RequestMethod.POST,
	        consumes=MediaType.APPLICATION_JSON_VALUE,
	        produces=MediaType.APPLICATION_JSON_VALUE
	       )
     public ResponseEntity<StringResult> tregister(@RequestBody TenderInfo t)
       {
		   System.out.println(t.getTendername());
		   System.out.println(t.getClosingdate());
           tr.save(t);
         return new ResponseEntity<StringResult>(new StringResult(t.getTendername()),HttpStatus.CREATED);

       }
	
	
	@RequestMapping(path="/registerBid",
	        method=RequestMethod.POST,
	        consumes=MediaType.APPLICATION_JSON_VALUE,
	        produces=MediaType.APPLICATION_JSON_VALUE
	       )
	public ResponseEntity<StringResult> bidregister(@RequestBody BidValue bv)
	{
	
	br.save(bv);
	return new ResponseEntity<StringResult>(new StringResult(bv.getTenderid()),HttpStatus.CREATED);
	
}
	
	
	@RequestMapping(path="/findVender",
			       method=RequestMethod.POST,
			       produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StringResult> login(@RequestParam("user") String user,@RequestParam("password") String password)
	{
		System.out.println(user+" "+password);
		List<VenderInfo> l=new ArrayList<VenderInfo>();
		l=vr.findAll();
		for(VenderInfo v:l)
		{
			if((v.getEmail().equals(user))&&(v.getPass().equals(password)))
				{
				return new ResponseEntity<StringResult>(new StringResult(v.getName()),HttpStatus.CREATED);
				}
				
		}
	   return new ResponseEntity<StringResult>(new StringResult("Failed"),HttpStatus.CREATED);	
	}
	
	
	
	
	@RequestMapping(
			       path="/searchbytenderid",
			       method=RequestMethod.POST,
			       produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TenderInfo> searchbytenderid(@RequestParam("ser") String ser)
	{
		//System.out.println("hello"+ser);
		TenderInfo t=tr.findByTenderid(ser);
		//System.out.println(t.toString());
		//System.out.println(t.getTendername());
		return new ResponseEntity<TenderInfo>(t,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(
		       path="/searchbyvenderid",
		       method=RequestMethod.POST,
		       produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<VenderInfo> searchbyvenderid(@RequestParam("vendername") String vendername)
{
	//System.out.println("hello"+ser);
	VenderInfo t=vr.findByName(vendername);
	//System.out.println(t.toString());
	//System.out.println(t.getTendername());
	return new ResponseEntity<VenderInfo>(t,HttpStatus.CREATED);
}
	
	
	
	@RequestMapping(
		       path="/searchbydate",
		       method=RequestMethod.POST,
		       produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TenderInfo>> searchbydate(@RequestParam("date") String date)
{
	List<TenderInfo> l=new ArrayList<TenderInfo>();
	l=tr.findByDate(date);
	return new ResponseEntity<List<TenderInfo>>(l,HttpStatus.CREATED);
}
	
	@RequestMapping(
		       path="/bidawards",
		       method=RequestMethod.POST,
		       produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<BidValue>> bidawards(@RequestParam("date") String date)
{
	List<BidValue> l=new ArrayList<BidValue>();
	List<BidValue> temp=new ArrayList<BidValue>();
	List<BidValue> res=new ArrayList<BidValue>();
	Set<String> s=new HashSet<String>();
	l=br.findresult(date);
	
	for(BidValue t:l)
		s.add(t.getTenderid());
	for(String str:s)
	{
		for(BidValue t:l)
		{
			if(t.getTenderid().equals(str))
					temp.add(t);
		}
		BidValue q=temp.get(0);
		for(int i=1;i<temp.size();i++)
		{
			if(temp.get(i).getBidvalue()<q.getBidvalue())
				q=temp.get(i);
		}
		res.add(q);
		temp.removeAll(temp);
	}
	return new ResponseEntity<List<BidValue>>(res,HttpStatus.CREATED);
}
	
	
	@RequestMapping(
		       path="/searchbyclassi",
		       method=RequestMethod.POST,
		       produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TenderInfo>> searchbyclassi(@RequestParam("classification") String classi)
{
	List<TenderInfo> l=new ArrayList<TenderInfo>();
	l=tr.findByClassification(classi);
	return new ResponseEntity<List<TenderInfo>>(l,HttpStatus.CREATED);
}
	
	@RequestMapping(
		       path="/searchbystatus",
		       method=RequestMethod.POST,
		       produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TenderInfo>> searchbystatus(@RequestParam("status") String sta)
{
	List<TenderInfo> l=new ArrayList<TenderInfo>();
	l=tr.findByStatus(sta);
	return new ResponseEntity<List<TenderInfo>>(l,HttpStatus.CREATED);
}
	
	
	@RequestMapping(
			path="/delTender",
			method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<StringResult> deltender(@RequestParam("del") String delten )
	{
		List<TenderInfo> l=new ArrayList<TenderInfo>();
		l=tr.findAll();
        for(TenderInfo t:l)
        {
        	if(t.getTenderid().equals(delten))
        	{
        		tr.delete(t);
        		return new ResponseEntity<StringResult>(new StringResult("Deleted"),HttpStatus.CREATED);
        	
        	}
        }
        return new ResponseEntity<StringResult>(new StringResult("Failed in deletion"),HttpStatus.CREATED);
		
	}
	
	
	
	@RequestMapping(
			       path="/alltender",
			       method=RequestMethod.POST,
			       produces=MediaType.APPLICATION_JSON_VALUE
			       )
	public ResponseEntity<List<TenderInfo>> alltender()
	{
		List<TenderInfo> l=new ArrayList<TenderInfo>();
		l=tr.findAll();
		return new ResponseEntity<List<TenderInfo>>(l,HttpStatus.CREATED);
	}

}
