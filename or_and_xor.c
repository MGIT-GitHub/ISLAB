/*
Write a C program that contains a string (char pointer) with a value ‘Hello world’. 
The program should AND or and XOR each character in this string with 127 and display the result.
/*

#include <stdio.h>
void main() {
    // Initialize the string
    char *str = "Hello world";
    // Print the original string
    printf("Original string: %s\n", str);
    printf("Character\tOR with 127\tAND with 127\tXOR with 127\n");
    printf("---------\t-----------\t-------------\t-------------\n");
    for (int i = 0; str[i] != '\0'; i++) {
        char orResult = str[i] | 127;
        char andResult = str[i] & 127;
        char xorResult = str[i] ^ 127;
        printf("%c\t\t\t\t%d\t\t\t%d\t\t\t\t%d\n", str[i], orResult, andResult, xorResult);
    }
}
