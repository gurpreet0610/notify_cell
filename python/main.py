from text_message import text_mess
import json

tx= text_mess()
number= input("Enter the number you want to send message (Don't enter Country code):")
number = '91' + number
message=input("Enter the message:")


response=tx.sendSMS(number,message)
response= json.loads(response)
print(response["status"])