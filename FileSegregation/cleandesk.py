from pathlib import Path
from time import sleep

from watchdog.observers import Observer

from file import EventHandler

if __name__ == '__main__':
    paths = ['C:/Users/Lenovo/Downloads', 'C:/Users/Lenovo/Desktop']
    # watch_path = 'C:/Users/Lenovo/Downloads'
    destination_root ='D:/Desktop/'
    for watch_path in paths:
        event_handler = EventHandler(watch_path=watch_path, destination_root=destination_root)
        observer = Observer()
        observer.schedule(event_handler, f'{watch_path}', recursive=True)
        observer.start()

    try:
        while True:
            sleep(60)
    except KeyboardInterrupt:
        observer.stop()
    observer.join()