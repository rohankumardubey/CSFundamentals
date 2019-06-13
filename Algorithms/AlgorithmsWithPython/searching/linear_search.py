# This function will find the specified key in the array
def linear_search(array, key):
    # Loop until we find the key in the array
    for i in range(len(array)):

        # If the current element in the array is equal to the specified key
        if array[i] == key:
            return "Key {} is present at index {}".format(key, i)

    return "Key {} is not in the array".format(key)


# Main function to execute the code
def main():
    # Array to be searched
    array = [4, 5, 7, 1, 3, 9, 0, 8, 2, 6]

    # Element to be searched in the array
    key = 8

    print(linear_search(array, key))


# Code to call the main function
if __name__ == '__main__':
    main()
