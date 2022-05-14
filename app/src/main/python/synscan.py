from scapy.all import *
import requests
import socket

ports = list(range(1,65535))

def SynScan(host):
    ans, unans = sr(IP(dst=host)/TCP(dport=ports,flags="S"),timeout=5,verbose=0)
    p = [s[TCP].dport for (s,r,) in ans if s[TCP].dport==r[TCP].sport and r[TCP].flags=="SA"]
    return p