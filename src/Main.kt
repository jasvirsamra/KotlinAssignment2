// Kotlin Assignment 2
// Jasvir Singh

fun main() {
    val original = "Welcome to Jasvir Kotlin World"
    val key = 3
    val encrypted = caesarCipher(original, key)
    val word1 = "sandwich"
    val word2 = "burger"
    val anagrams = areAnagrams(word1, word2)
    val str1 = "hello world"
    val str2 = "world"
    val subString = isSubstring(str1, str2)
    val inputString = "Kotlin is a concise and powerful language"
    val longestWord = findLongestWord(inputString)

    println("A. Encrypted: $encrypted")
    println("B. Are \"$word1\" and \"$word2\" anagrams? $anagrams")
    println("C. Is \"$str2\" a substring of \"$str1\"? $subString")
    println("D. The longest word is: \"$longestWord\"")
}

// A. Caesar Cipher (Different loop structure using map)
fun caesarCipher(input: String, key: Int): String {
    val shift = key % 26
    return input.map { char ->
        when {
            char.isLowerCase() -> ('a' + (char.code - 'a'.code + shift) % 26)
            char.isUpperCase() -> ('A' + (char.code - 'A'.code + shift) % 26)
            else -> char
        }
    }.joinToString("")
}

// B. Anagram Check (Using frequency count instead of sort)
fun areAnagrams(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false

    val frequency1 = word1.lowercase().groupingBy { it }.eachCount()
    val frequency2 = word2.lowercase().groupingBy { it }.eachCount()

    return frequency1 == frequency2
}

// C. Substring Check (Manual implementation of indexOf logic)
fun isSubstring(str1: String, str2: String): Boolean {
    if (str2.isEmpty()) return true
    if (str2.length > str1.length) return false

    for (i in 0..str1.length - str2.length) {
        if (str1.substring(i, i + str2.length) == str2) return true
    }
    return false
}

// D. Longest Word (Using fold instead of maxByOrNull)
fun findLongestWord(input: String): String {
    return input.split(Regex("\\s+")).fold("") { acc, word ->
        if (word.length > acc.length) word else acc
    }
}
