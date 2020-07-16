import shutil
from datetime import date
from time import sleep
from pathlib import Path
import os,stat
from watchdog.events import FileSystemEventHandler
from extensions import extension_paths


class EventHandler(FileSystemEventHandler):
    def __init__(self, watch_path: Path, destination_root: Path):
        self.watch_path = watch_path
        self.destination_root = destination_root

    def on_any_event(self, event):
        sleep(50)
        os.chmod(
        self.watch_path,
        stat.S_IMODE(os.stat(self.watch_path).st_mode)
        |(stat.S_IWUSR | stat.S_IWGRP | stat.S_IWOTH),
        )
        for child in os.listdir(self.watch_path):
            file_ext=os.path.splitext(child)[1]
            if  file_ext.lower() in extension_paths:
                destination_path = self.destination_root + extension_paths[file_ext.lower()]
                if(os.path.isfile(destination_path+"/"+child)==False):
                    shutil.move(self.watch_path+"/"+child, dst=destination_path)
