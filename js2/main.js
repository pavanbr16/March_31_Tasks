let arr = prompt('enter an array')
    .split(' ')
    .map((el) => +el),
  k = parseInt(prompt('enter k'));

let sum = (arr) => {
  return arr.reduce((x, y) => x + y, 0);
};

let run = (arr) => {
  let lb = 0,
    ub = arr.length,
    res = arr;

  if (sum(arr) < k) return 'no subarray exists';

  while (lb < ub) {
    let sub = arr.slice(lb, ub);
    if (sum(sub) > k) {
      lb++;
      res = sub;
    } else ub--;
  }
  return res;
};

console.log(run(arr));
