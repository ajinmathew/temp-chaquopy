from Enum import *
import threading
import requests

def main(host):
    enum = Enum()
    enum.thread_list=[]
    for t in range(100):
        thread=threading.Thread(target=enum.scnenum)
        enum.thread_list.append(thread)
    for thread in enum.thread_list:
        thread.start()
    for thread in enum.thread_list:
        thread.join(1.0)

    return enum.discovered_subdomains