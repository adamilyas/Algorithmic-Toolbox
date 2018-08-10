# Uses python3
import sys

def lcm_naive(a, b):
    for l in range(1, a*b + 1):
        if l % a == 0 and l % b == 0:
            return l

    return a*b

def gcd_r(a,b):
    if a==0:
        return b
    elif b==0:
        return a
    else:
        return gcd_r(b, a%b)

def lcm_fast(a,b):
    """
    Based on this formula
    a*b = gcd*lcm
    """
    return int(a/gcd_r(a,b)) * int(b)

if __name__ == '__main__':
    #input = sys.stdin.read()
    a, b = map(int, input().split())
    #print(lcm_naive(a, b))
    print(lcm_fast(a, b))