let entry = prompt('enter an array ')
  .split(' ')
  .map((el) => +el);

function run(arr) {
  let res = [];

  for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      let sub = arr.slice(i, j + 1);
      if (check(arr.slice(i, j + 1)) === true) {
        if (sub.length > res.length) res = sub;
      }
    }
  }

  return res;
}

function check(arr) {
  arr.sort();
  for (let i = 0; i < arr.length - 1; i++) {
    if (arr[i] + 1 != arr[i + 1]) return false;
  }
  return true;
}

console.log(run(entry));
