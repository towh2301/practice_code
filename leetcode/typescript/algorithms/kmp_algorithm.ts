// function kmpAlgorithm(s: string, pattern: string): number[] {
// 	return [];
// }

// Do the kmpLookupTable function first
function kmpLookupTableExample(s: string): number[] {
	let lps: number[] = new Array(s.length).fill(0);
	let len = 0;
	let idx = 1;

	while (idx < s.length) {
		if (s[idx] === s[len]) {
			len++;
			lps[idx] = len;
			idx++;
		} else {
			if (len) {
				len = lps[len - 1];
			} else {
				lps[idx] = 0;
				idx++;
			}
		}
	}
	return lps;
}

console.log(kmpLookupTableExample("abcbaabcaaabc"));
