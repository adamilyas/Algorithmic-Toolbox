# Uses python3
import sys

def gcd_naive(a, b):
    current_gcd = 1
    for d in range(2, min(a, b) + 1):
        if a % d == 0 and b % d == 0:
            if d > current_gcd:
                current_gcd = d

    return current_gcd

# using recurring
def gcd_r(a,b):
    if a==0:
        return b
    elif b==0:
        return a
    else:
        return gcd_r(b, a%b)

if __name__ == "__main__":
    #input = sys.stdin.read()
    a, b = map(int, input().split())
    #print(gcd_naive(a, b))
    print(gcd_r(a, b))