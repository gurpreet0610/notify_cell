import urllib.request
import urllib.parse
class text_mess:    
        def sendSMS(self,number, message):
            data =  urllib.parse.urlencode({'apikey': 'Vzw3ZL8CVX8-ql97jtceMBhzqLD1ShXhEYDTmqZ8t8', 'numbers': number,
                'message' : message, 'sender': 'TXTLCL'})
            data = data.encode('utf-8')
            request = urllib.request.Request("https://api.textlocal.in/send/?")
            f = urllib.request.urlopen(request, data)
            fr = f.read()
            return(fr)
    

