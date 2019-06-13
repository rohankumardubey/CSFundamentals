def ternary_search(array, key, start, end):
    if start <= end:

        # First middle element
        mid1 = start + (end - start) // 3

        # Second middle element
        mid2 = end - (end - start) // 3

        if array[mid1] == key:
            return "Key {} is found at index {}".format(key, mid1)

        if array[mid2] == key:
            return "Key {} is found at index {}".format(key, mid2)

        if key < array[mid1]:
            return ternary_search(array, key, start, mid1 - 1)

        elif key > array[mid2]:
            return ternary_search(array, key, mid2 + 1, end)

        else:
            return ternary_search(array, key, mid1 + 1, mid2 - 1)

    return "Key {} is not in the array".format(key)


# Main function to execute the code
def main():
    # Array to be searched
    array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]

    # Element to be searched in the array
    key = 4

    # Start index of the array
    start = 0

    # End index of the array
    end = len(array) - 1

    print(ternary_search(array, key, start, end))


# Code to call the main function
if __name__ == '__main__':
    main()
