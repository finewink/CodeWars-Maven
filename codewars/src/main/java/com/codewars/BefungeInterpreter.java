package com.codewars;

import java.util.Random;
import java.util.Stack;

public class BefungeInterpreter {
    StringBuffer output = new StringBuffer();
    Stack<Integer> stack = new Stack<Integer>();

    public String interpret(String code) {
        String[] lines = code.split("\n");
        char[][] plane = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            plane[i] = lines[i].toCharArray();
        }
        next(plane, 0, 0, 1, 0, false);

        return output.toString();
    }

    /**
     * 
     * @param plane      befunge plane
     * @param line       Nth line: indicate plane[line]
     * @param index      Nth index of a line: indicate plane[line][index]
     * @param directionX horizontal direction. 1 to right, -1 to left. 0 means
     *                   vertical move.
     * @param directionY vertical direction. 1 to down, -1 to up. 0 means horizontal
     *                   move.
     */
    public void next(char[][] plane, int line, int index, int directionX, int directionY, boolean mode) {
        char value = plane[line][index];

        do {
            if (mode & value != '"') {
                stack.push((int) value);
            } else {
                switch (value) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': {
                    if (!mode) {
                        stack.push(Character.getNumericValue(value));
                    } else {
                        stack.push((int) value);
                    }
                    break;
                }
                case '+': {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case '-': {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                    break;
                }
                case '*': {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b * a);
                    break;
                }
                case '/': {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    break;
                }
                case '%': {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b % a);
                    break;
                }
                case '!': {
                    int a = stack.pop();
                    if (a == 0) {
                        stack.push(1);
                    } else {
                        stack.push(0);
                    }
                    break;
                }
                case '`': {
                    int a = stack.pop();
                    int b = stack.pop();
                    if (b > a) {
                        stack.push(1);
                    } else {
                        stack.push(0);
                    }
                    break;
                }
                case '>': {
                    directionX = 1;
                    directionY = 0;
                    break;
                }
                case '<': {
                    directionX = -1;
                    directionY = 0;
                    break;
                }
                case '^': {
                    directionX = 0;
                    directionY = -1;
                    break;
                }
                case 'v': {
                    directionX = 0;
                    directionY = 1;
                    break;
                }
                case '?': {
                    directionX = new Random().nextInt(3) - 1;
                    if (directionX == 0) {
                        directionY = new Random().nextBoolean() ? 1 : -1;
                    } else {
                        directionY = 0;
                    }
                    break;
                }
                case '_': {
                    int a = stack.pop();
                    if (a == 0) {
                        directionX = 1;
                        directionY = 0;
                        break;
                    } else {
                        directionX = -1;
                        directionY = 0;
                        break;
                    }
                }
                case '|': {
                    int a = stack.pop();
                    if (a == 0) {
                        directionX = 0;
                        directionY = 1;
                        break;
                    } else {
                        directionX = 0;
                        directionY = -1;
                        break;
                    }
                }
                case '"': {
                    mode = !mode;
                    break;
                }
                case ':': {
                    if (stack.empty()) {
                        stack.push(0);
                    } else {
                        stack.push(stack.peek());
                    }
                    break;
                }
                case '\\': {
                    if (!stack.empty()) {
                        int a = stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(a);
                            stack.push(0);
                        } else {
                            int b = stack.pop();
                            stack.push(a);
                            stack.push(b);
                        }
                    }
                    break;
                }
                case '$': {
                    stack.pop();
                    break;
                }
                case '.': {
                    output.append(stack.pop());
                    break;
                }
                case ',': {
                    output.append((char) stack.pop().intValue());
                    break;
                }
                case '#': {
                    directionX = directionX * 2;
                    directionY = directionY * 2;
                    break;
                }
                case 'p': {
                    int y = stack.pop();
                    int x = stack.pop();
                    int v = stack.pop();
                    plane[y][x] = (char) v;
                    break;
                }
                case 'g': {
                    int y = stack.pop();
                    int x = stack.pop();

                    stack.push((int) plane[y][x]);
                    break;
                }
                case '@': {
                    while (!stack.empty()) {
                        int a = stack.pop();
                        if (a < 10) {
                            output.append(a);
                        } else {
                            output.append((char) a);
                        }
                    }
                    return;
                }
                case ' ': {
                    break;
                }
                default: {
                    if (mode) {
                        stack.push((int) value);
                    }

                    break;
                }
                }
            }

            line = line + directionY;
            index = index + directionX;
            value = plane[line][index];

            if (Math.abs(directionX) > 1) {
                directionX = directionX / 2;
            }
            if (Math.abs(directionY) > 1) {
                directionY = directionY / 2;
            }
        } while (value != '@');
    }
}
