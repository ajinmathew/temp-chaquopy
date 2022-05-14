from Wappalyzer import Wappalyzer, WebPage

def main(product):
    try:
        webpage = WebPage.new_from_url(product)
        wappalyzer = Wappalyzer.latest()
        x = wappalyzer.analyze_with_versions_and_categories(webpage)
        return x
    except:
        return "Not Found!..."