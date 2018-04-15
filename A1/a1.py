#Program:

import time
import unittest

class TestThisShit(unittest.TestCase):
	def test1(self):
		self.assertEqual(func("input.txt",num),True)
	def test2(self):
		self.assertEqual(func("input.txt",-999),False)

		
class Search:
	arr=[]
	def __init__(self,a):
		self.arr=a

	def Partition(self,p,q):
		pivot=self.arr[p]
		i=p
		for j in range(p+1,q+1):
			if(self.arr[j]<pivot):
				i+=1
				temp=self.arr[i]
				self.arr[i]=self.arr[j]
				self.arr[j]=temp
		temp=self.arr[i]
		self.arr[i]=self.arr[p]
		self.arr[p]=temp	
		return i
	
	def QuickSort(self,p,q):
		if(p<q):
			r=self.Partition(p,q)
			self.QuickSort(p,r-1)
			self.QuickSort(r+1,q)
		return self.arr
	
	def BinarySearch(self,num,low,high):
		if(low<high):
			mid=low+(high-low)/2
			if(num==self.arr[mid]):
				return mid
			elif (num<self.arr[mid]):
				return self.BinarySearch(num,low,mid)
			else:
				return self.BinarySearch(num,mid+1,high)
		else:
			return -1

def func(filename,num):
	a=[]
	try:
		with open(filename,'r') as f:
			for line in f:
				a.append(int(line))
		f.close()
		obj = Search(a)
		print "Sorted Array:"
		print obj.QuickSort(0,len(a)-1)
		
		ind=obj.BinarySearch(num,0,len(a))
		if(ind+1):
			print "Number found at position",ind
			return True
		else:
			print "Number not found"

	except Exception as e:
		print "\n"
	
	return False

if __name__=='__main__':
	filename=raw_input("Enter Filename:")
	num=input("Enter element to be searched:")
	func(filename,num)	

unittest.main()


'''
Input.txt
100
60
54
43
19
26
32
90
70
80

OUTPUT:

ravi@ravi-Vostro-3446:~/CL-3/A1$ python binary_search.py 
	1. Binary search with recursion
	2. Binary search without recursion
	3. Linear search
 	Enter your Choice: 1
Enter filename: 
Input.txt
Enter key to be searched: 
54
Before sorted array is: 
[100, 60, 54, 43, 19, 26, 32, 90, 70, 80]
After sorted array is: 
[19, 26, 32, 43, 54, 60, 70, 80, 90, 100]
('Time in seconds', '0.00000905990600585938')
('Element Present at Position ', 4, ' in Array\n')
ravi@ravi-Vostro-3446:~/CL-3/A1$ python binary_search.py 
	1. Binary search with recursion
	2. Binary search without recursion
	3. Linear search
 	Enter your Choice: 2
Enter filename:
Input.txt
Enter key to be searched: 
26
Before sorted array is: 
[100, 60, 54, 43, 19, 26, 32, 90, 70, 80]
After sorted array is: 
[19, 26, 32, 43, 54, 60, 70, 80, 90, 100]
('Time in seconds', '0.00000882148742675781')
('Element Present at Position', 1, ' in Array\n')
ravi@ravi-Vostro-3446:~/CL-3/A1$ python binary_search.py 
	1. Binary search with recursion
	2. Binary search without recursion
	3. Linear search
 	Enter your Choice: 3
Enter filename: 
Input.txt
Enter key to be searched: 
90
('Element Present at Position', 7, ' in Array\n')
ravi@ravi-Vostro-3446:~/CL-3/A1$ 

'''	
