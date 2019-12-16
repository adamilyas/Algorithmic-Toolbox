inversionCount = 0

def merge(firstHalf, secondHalf):
    # sorted ls1, ls2
    merged = [None] * (len(firstHalf) + len(secondHalf))
    firstHalfIndex = secondHalfIndex = currentIndex = 0
    
    while firstHalfIndex < len(firstHalf) and secondHalfIndex < len(secondHalf):
        if firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]:
            merged[currentIndex] = firstHalf[firstHalfIndex]
            firstHalfIndex += 1
            currentIndex += 1
        else:
            # there is an inversion
            global inversionCount
            inversionCount += len(firstHalf) - firstHalfIndex

            merged[currentIndex] = secondHalf[secondHalfIndex]
            secondHalfIndex += 1
            currentIndex += 1

    if firstHalfIndex == len(firstHalf):
        # add the remaining of secondHalf
        while secondHalfIndex < len(secondHalf):
            merged[currentIndex] = secondHalf[secondHalfIndex]
            currentIndex += 1
            secondHalfIndex += 1
    elif secondHalfIndex == len(secondHalf):
        # add the remaining of secondHalf
        while firstHalfIndex < len(firstHalf):
            merged[currentIndex] = firstHalf[firstHalfIndex]
            currentIndex += 1
            firstHalfIndex += 1

    return merged

def mergeSort(arr):
    if len(arr) == 1:
        return arr

    mid = len(arr)//2
    firstHalf = mergeSort(arr[:mid])
    secondHalf = mergeSort(arr[mid:])
    return merge(firstHalf, secondHalf)

def CountSplitInv(B,C):
    i = 0
    j = 0
    count = 0
    D = []
    while i<len(B) and j<len(C):
        D.extend([min(B[i],C[j])])
        if B[i] < C[j]:
            i = i + 1
        else:
            count +=len(B[i:])
            j+=1
    D.extend(B[i:])
    D.extend(C[j:])
    Z = count
    return D,Z

def Sort_Count(A):
    n = len(A)
    if n > 1:
        splitposition = n // 2
        B,X = Sort_Count(A[:-splitposition])
        C,Y = Sort_Count(A[-splitposition:])
        D,Z = CountSplitInv(B,C)
        return D,X+Y+Z
    else:
        return A,0

if __name__ == "__main__":
    f = open("IntegerArray.txt", "r")
    ls = []
    for line in f:
        ls.append(int(line))
    f.close()
    print(Sort_Count(ls)[1])

    # ls = [5,7,32,76,32,7,2,1]
    # print(mergeSort(ls))
    mergeSort(ls)
    print(inversionCount)
    # print(Sort_Count(ls))