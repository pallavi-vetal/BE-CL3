from pymongo import MongoClient
from datetime import datetime
def load(filename):
	con = MongoClient("127.0.0.1",27017)
	db = con.test.tb2
	file = open(filename,'r').read().strip().split('\n')
	for line in file :
		record = line.strip().split(',')
		print record
		record = [int(e) for e in record]
		document = {"index":record[0],"time":(datetime.now()),"temp":record[1]}
		db.insert(document)

load("data.txt")	