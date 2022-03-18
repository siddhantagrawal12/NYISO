//Author - Siddhant Agrawal

// Problem: 
// You will be given a string (x) featuring a cat 'C', a dog 'D' and a mouse 'm'. The rest of the string will be made up of '.' (periods)
// You need to find out if the cat can catch the mouse from it's current position. The cat can jump (j) characters.
// Also, the cat cannot jump over the dog.
// So:
// if j = 5:
// ..C.....m. returns 'Caught!' <-- not more than j characters between
// .....C............m...... returns 'Escaped!' <-- as there are more than j characters between the two, the cat can't jump far enough
// if j = 10:
// ...m.........C...D returns 'Caught!' <--Cat can jump far enough and jump is not over dog
// ...m....D....C....... returns 'Protected!' <-- Cat can jump far enough, but dog is in the way, protecting the mouse
// Finally, if all three animals are not present, return 'boring without all three'

package CatMouse;
import java.lang.*;

class CatMouse {
    //Inputs: 
    //x is the given string containing cat, dog and mouse
    //j is the characters jumped by the cat
    public static String catmouse(String x, int j) { //return type: string
 
        int c_ind = -1; //initial index value of the cat
        int d_ind = -1; //initial index value of the dog
        int m_ind = -1; //initial index value of the mouse

        //Checking if cat, mouse and dog are present in the string
        //if they are present, assigning it to the index value
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == 'C') {
                c_ind = i;
            }
            if (x.charAt(i) == 'D') {
                d_ind = i;
            }
            if (x.charAt(i) == 'm') {
                m_ind = i;
            }
        }
        
        //C - Cat
        //D - Dog
        //m - Mouse

        //C, m and D not present (edge case)
        if (c_ind == -1 && d_ind == -1 && m_ind == -1) {
            return "boring without all three";
        }

        //C and D not present (edge case)
        if (c_ind == -1 && d_ind == -1 && m_ind != -1) {
            return "Escaped, NO CAT NO DOG!";
        }

        //C and m not present (edge case)
        if (c_ind == -1 && d_ind != -1 && m_ind == -1) {
            return "Boring, NO CAT NO MOUSE!";
        }

        //D and m not present (edge case)
        if (c_ind != -1 && d_ind == -1 && m_ind == -1) {
            return "Boring, NO DOG NO MOUSE!";
        }

        //m not present (edge case)
        if (c_ind != -1 && d_ind != -1 && m_ind == -1) {
            return "Boring, NO MOUSE!";
        }

        //C not present (edge case)
        if (c_ind == -1 && d_ind != -1 && m_ind != -1) {
            return "Escaped, NO CAT!";
        }

        //C, m and D are present
        if (c_ind != -1 && d_ind == -1 && m_ind != -1) {
            if ((Math.abs(c_ind - m_ind) - 1) <= j) { //condition to check if C can reach the m, and Math.abs gives the absolute value of the integer
                return "Caught!";
            } else {
                return "Escaped!";
            }
        }
        if (c_ind != -1 && d_ind != -1 && m_ind != -1) {
            if ((m_ind < d_ind && d_ind < c_ind) || (c_ind < d_ind && d_ind < m_ind)) { //condition to check if D is in between C and m (&&[and] and ||[or] are the logical opertors)
                return "Protected!";
            } else {
                if ((Math.abs(c_ind - m_ind) - 1) <= j) {
                    return "Caught!";
                } else {
                    return "Escaped!";
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(catmouse(".......................", 5));           //boring without all three
        System.out.println(catmouse("..........m......", 10));                //Escaped, NO CAT NO DOG!
        System.out.println(catmouse(".....D......", 5));                      //Boring, NO CAT NO MOUSE!
        System.out.println(catmouse(".....C....", 8));                        //Boring, NO DOG NO MOUSE!
        System.out.println(catmouse(".....C............D......", 9));         //Boring, NO MOUSE!
        System.out.println(catmouse("...m............D", 10));                //Escaped, NO CAT!
        System.out.println(catmouse("..C.....m.", 5));                        //Caught! 
        System.out.println(catmouse(".....C............m......", 5));         //Escaped!
        System.out.println(catmouse("...m.........C...D", 10));               //Caught!
        System.out.println(catmouse("...m....D....C.......", 10));            //Protected!
        System.out.println(catmouse("...C....D....m.......", 10));            //Protected!
        System.out.println(catmouse("...m................C..D.....", 8));     //Escaped!
    }
}

