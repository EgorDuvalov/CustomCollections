package com.innowise.duvalov;

public class PalindromeChecker<T> {
    public boolean isPalindrome(T element) {
        return element.toString().equals(reverse(element.toString()));
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
