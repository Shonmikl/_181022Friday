package org.example._2023_06_02;
//O(n) + O(n)
public class Famous {
    Famous getFamous(Famous[] person) {
        Famous f = null;
        int firstIdx = 0;
        int lastIdx = person.length - 1;

        while (firstIdx != lastIdx) {
            if (person[firstIdx].knows(person[lastIdx])) {
                firstIdx++;
            } else {
                lastIdx--;
            }
        }

        for (int i = 0; i < person.length; i++) {
            if (i != firstIdx
                    && (person[i].knows(person[firstIdx])
                    || person[firstIdx].knows(person[i]))) {
                f = null;
            }
            f = person[firstIdx];
        }

        return f;
    }

    private boolean knows(Famous person) {
        return false;
    }
}