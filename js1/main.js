let arr = [1, 2, 3, 4, 6, 8, 5, 10, 20, 11, 12];

let run = (arr) => {
  for (let i = 0; i < arr.length; i++) {
    let diff = null,
      temp;
    for (let j = 0; j < arr.length; j++) {
      if (diff === null && arr[j] - arr[i] > 0) {
        diff = arr[j] - arr[i];
        temp = arr[j];
      } else if (arr[j] - arr[i] < diff && arr[j] - arr[i] > 0) {
        diff = arr[j] - arr[i];
        temp = arr[j];
      }
    }

    if (diff === null) arr[i] = -1;
    else arr[i] = temp;
  }

  return arr;
};

console.log(run(arr));
