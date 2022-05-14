import requests
class Enum:
    def __init__(self):
        self.domain="google.com"
        #file = open("subdomain.txt")
        #content = file.read()
        #self.subdomains = content.splitlines()
        self.subdomains = ['login', 'auth', 'signup', 'signin', 'registeration', 'www', 'ftp', 'mobile', 'video', 'image', 'static', 'app', 'service', 'tools', 'email', 'local', 'data', 'file', 'live', 'www.api', 'api', 'news', 'games', 'courses', 'result', 'downloads', 'status', 'admin', 'search', 'research', 'list', 'lite', 'site', 'user', 'account', 'administrator', 'localhost', 'smtp', 'pop', 'cmd', 'shop', 'beta', 'sql', 'secure', 'demo', 'web', 'portal', 'cdn', 'dns', 'apps', 'info', 'office', 'exchange', 'test', 'docs', 'dhcp', 'new', 'accounts', 'alpha', 'alumini', 'backup', 'backups', 'git', 'community', 'client', 'database', 'developers', 'development', 'gallery', 'go', 'google', 'guest', 'help', 'home', 'host', 'id', 'info', 'payment', 'php', 'phpmyadmin', 'server', 'public', 'code', 'siteadmin', 'sitebuilder', 'log', 'logs', 'staff', 'student', 'tunnel', 'www-data', 'location', 'locations', 'lib', 'files', 'class', 'edu', 'access', 'book', 'online']
        self.discovered_subdomains = []


    def scnenum(self):
        while len(self.subdomains):
            subdomain = self.subdomains.pop(0)
            fullname = f"{subdomain}.{self.domain}"
            url = f"https://{fullname}"
            try:
                response = requests.get(url)
                responseOpt = requests.options(url)
                self.discovered_subdomains.append([fullname,str(response.status_code),responseOpt.raw.getheader('allow')])
                #print(url+" : "+str(response.status_code))
            except requests.ConnectionError:
                # if the subdomain does not exist, just pass, print nothing
                pass
            else:
                #self.discovered_subdomains.append(fullname)
                pass

