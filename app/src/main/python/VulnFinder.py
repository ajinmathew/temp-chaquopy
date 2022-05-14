import requests
import json

def main(product):
    try:
        r = requests.get('http://www.exploitalert.com/api/search-exploit?name=%s'%(product))
        if r.status_code == 200:
            out = json.loads(r.text)
            return out
        #try:
        #    out = json.loads(r.text)
            #for i in out:
            #print(i)
        #    return out
        #except json.decoder.JSONDecodeError:
            #print(red,'[-] Exploit not found!')
        #    return "Exploit not found!"
    except:
        return "Exploit not found!"