# Uses python3
import sys

def fibonacci_sum_naive(n):
    if n <= 1:
        return n

    previous = 0
    current  = 1
    sum      = 1

    for _ in range(n - 1):
        previous, current = current, previous + current
        sum += current

    return sum % 10

def gen_last_digit(n):
    seq = {0:0, 1:1}
    for i in range(2,n+1): # from 2 to n
        seq[i] = (seq[i-1] + seq[i-2])%10
        
    return seq

if __name__ == '__main__':
    #input = sys.stdin.read()
    n = int(input())
    seq = list(gen_last_digit(n).values())
    print(sum(seq[:n+1])%10)
