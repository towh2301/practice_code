function shortestPalindrome(s: string): string {
	const reversedString = s.split("").reverse().join("");
	const combinedString = s + reversedString; // concatenate reversed and original string
	const lps = kmpLookupTable(combinedString); // Generate lookup table
	const prefixLength = lps[combinedString.length - 1]; // Find the longest prober prefix/suffix

	// Append remaining un-reversed characters  to original string
	return reversedString.slice(0, reversedString.length - prefixLength) + s;
}

// Generate lookup table
function kmpLookupTable(s: string): number[] {
	const lps: number[] = Array(s.length).fill(0);
	let len = 0;
	let i = 1;

	while (i < s.length) {
		if (s[i] === s[len]) {
			len++;
			lps[i] = len;
			i++;
		} else {
			if (len) {
				len = lps[len - 1];
			} else {
				lps[i] = 0;
				i++;
			}
		}
	}

	return lps;
}

console.log(shortestPalindrome("aacecaaa")); // Output: "aaacecaaa"
console.log(shortestPalindrome("abcd")); // Output: "dcbabcd"
