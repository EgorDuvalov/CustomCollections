package com.innowise.duvalov;

import com.innowise.duvalov.stack.Stack;

public class PalindromeChecker {
    public boolean isPalindrome(Stack element){
        StringBuilder sb = new StringBuilder(element.toString());
        return sb.equals(sb.reverse());
    }
}
