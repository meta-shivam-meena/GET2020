function removeConsecutiveCharactersRecursively(str) {
  let startIndex = -1;
  while (startIndex < str.length - 1) {
    startIndex++;
    if (str.charAt(startIndex) === str.charAt(startIndex + 1)) {
      console.log(str.charAt(startIndex));
      let endIndex = startIndex + 2;
      while (endIndex < str.length && str.charAt(endIndex) === str.charAt(startIndex)) {
        endIndex++;
      }
      str = str.substring(0, startIndex) + str.substring(endIndex, str.length);
      startIndex = -1;
    }
  }
  return str;
}

console.log(removeConsecutiveCharactersRecursively("eeabcddcbfgf"));