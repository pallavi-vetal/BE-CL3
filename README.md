# BE-CL3
#Full Working Assignments:
A1,A2,A3,A4,A6,B1,B2
**************************************************************
#Remaining
A5=B3,C1,C2,C3 - Cloud Computing
***************************************************************
#A1: Binary Search - Python
	1) Contains unittesting
	2) uses QuickSorting
	3) takes input array from input.txt file

#A2:Concurrent QuickSort - Python
	1) Implemented using threads
	2) takes input from input.xml , performs unittesting

#A3:Booths Multiplication - Python - Web Application
	1) Make sure you have gekodriver for firefox
	2) Run A3.py on terminal1
	3) open browser with URL localhost:5000 . You can change port by mentioning it in A3.py
	4) Run test.py on terminal2 which contains selenium testing script

#A4:Dining Philosopher’s problem - Python
	1) Make sure you have pymongo installed on ur system
	2) Run a4.py
	3) To check database entries,run " mongo " command on terminal
	4) Execute following commands in mongo shell
		1.show dbs
			This will list all available databases
		2.use test
			Will switch to Test db
		3.show collections
			Will list all collections in ur Test db
		4.db.mycoll.find()
			This will display entries of philosphers

#A6:CloudSim
	1) cd cloudsim-3.0.2/jars
	2) java -classpath cloudsim-3.0.2.jar:cloudsim-examples-3.0.2.jar  org.cloudbus.cloudsim.examples.CloudSimExample1
	3) To run Docker commands:
		1)	create file helloworld.sh with contains echo "hie"
		2)	on terminal1 run " sudo docker run ubuntu /bin/echo 'Hello World' "
		3)	sudo docker run -it ubuntu /bin/bash
				This will create and switched to container
		4) Run ls - Note that container doesn't have helloworld.sh
		5) Now open new terminal
		6) run " sudo docker ps " on terminal2
			Now Note container ID in the output of above cmnd
		7) run docker cp helloworld.sh <ENTER YOUR CONTAINER ID HERE>:/helloworld.sh
		8)Now Switch to terminal 1
		9)Do ls
			This will list helloworld.sh
		10)chmod 777 helloworld.sh
		11)./helloworld.sh
 		
#B1:8 Queen's - python
	1) takes input form input1.json input2.json input3.json
	2) run b1.py

#B2:Plagarism - python
	1) Run b2.py
	2) on new terminal run b2_test.py

	
	
