//520. Detect Capital
public class LeetCode520 {

    //All upper case or except first char remaining are lowercase
    public boolean detectCapitalUse(String word) {
        return word.chars()
                .allMatch(Character::isUpperCase) ||
                word.chars()
                        .skip(1)
                        .allMatch(Character::isLowerCase);
    }
}
