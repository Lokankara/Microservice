#list
#array 
#tuple
#set
#dict

s = set()
s.add(1)
s.add(2)
s.remove(2)
s.discard(2)
for x in s: print(x)

A = {1, 2, 4, 8, 16}
B = set(range(2, 6))
C = A & B
C = A | B
C = A - B
C = A ^ B
A |= B
A &= B

d = {}
d = dict()
d= {"sun": 0, "mon": 1, "tues": 2, "wednes": 3}
d = dict([("sun",0), ("mon",1), ("tues",2)])

key ="mon"
if key in d:
    value = d[key]

votes = {}
for candidate in open("bucket.txt").read().splitlines():
    if candidate in votes:
        votes[candidate] += 1
    else:
        votes[candidate] = 1
rating = list(votes.pairs())
rating.sort(key=lambda p:p[1], reversed=True)


from collections import Counter
votes = Counter(open("bucket.txt").read().splitlines())
votes.most.common(3)

#  geometry_progretion
# Mersen 2**n -1 is_simple

