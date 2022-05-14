import socket
import threading
from EnumPort import *

def main(host):
    enumPort = EnumPort(host)
    enumPort.thread_list=[]
    for t in range(100):
        thread=threading.Thread(target=enumPort.scanport)
        enumPort.thread_list.append(thread)
    for thread in enumPort.thread_list:
        thread.start()
    for thread in enumPort.thread_list:
        thread.join(1.0)
    return enumPort.discovered_ports