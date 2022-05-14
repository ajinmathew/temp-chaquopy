import socket

def bannerGrab(ip,port):
    if port in [53,80,6980,443]:
        return ""
    try:
        s=socket.socket()
        s.settimeout(2)
        s.connect((ip,int(port)))
        banner=s.recv(1024)
        s.shutdown(1) # By convention, but not actually necessary
        s.close()
        #print(banner.decode("utf-8"))
        return banner.decode("utf-8")
    except Exception as e:
        return e