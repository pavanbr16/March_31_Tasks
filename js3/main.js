let arr = prompt('enter an array')
  .split(' ')
  .map((el) => +el);

let run = (arr) => {
  let bool = true;
  for (let i = 1; i < arr.length; i++) {
    let max = Math.max(arr[i], arr[i - 1]),
      min = Math.min(arr[i], arr[i - 1]);

    if (bool) {
      arr[i - 1] = min;
      arr[i] = max;
      bool = !bool;
    } else {
      arr[i - 1] = max;
      arr[i] = min;
      bool = !bool;
    }
  }

  return arr;
};

console.log(run(arr));
