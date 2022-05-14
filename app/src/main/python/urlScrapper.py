import requests
from bs4 import BeautifulSoup
def main(domain):
    url=f"https://{domain}"
    r = requests.get(url)
    soup= BeautifulSoup(r.content,"html.parser")
    anchor_list=[a['href']for a in soup.find_all('a',href=True) if a.text.strip()]
    anchor_set= set(anchor_list)
    li=[]
    check=[url,domain,"https","http","ftp"]
    [li.append(i) for i in anchor_set if i not in check]
    str1="https://"
    mi=[]
    for n in li:
        #if n not in check:
        si=[]
        if "https://" or "http://" not in n :
            str1=str1+n
            #str2=n+str1;
            mi.append(str1)
    return mi