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

def count_and_sort_votes(filename):
    votes = {}
    with open(filename, 'r') as file:
        for candidate in file:
            candidate = candidate.strip()
            if candidate in votes:
                votes[candidate] += 1
            else:
                votes[candidate] = 1
    rating = list(votes.items())
    rating.sort(key=lambda p: p[1], reverse=True)
    return rating


from collections import Counter

votes = Counter(open("bucket.txt").read().splitlines())
most_common_votes = votes.most_common(3)
print(most_common_votes)

#  geometry_progretion

