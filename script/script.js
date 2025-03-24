const img = new Image();
img.src = './water1.png';
const brightness = .4;

function flipList(data) {
  // There are several ways to flip a list (array) in JavaScript.
  // Here are a few common methods:

  // Method 1: Using the built-in reverse() method (modifies the original array)
  // list.reverse();
  // return list;

  // Method 2: Creating a new reversed array using a loop
  const reversedList = [];
  for (let i = data.length - 1; i >= 0; i--) {
    reversedList.push(data[i]);
  }
  return reversedList;
}
img.onload = function() {
  const canvas = document.createElement('canvas');
  canvas.width = img.width;
  canvas.height = img.height;
  const ctx = canvas.getContext('2d');
  ctx.drawImage(img, 0, 0);

  let imageData = ctx.getImageData(0, 0, img.width, img.height).data;
  let compressedData =[];

  for(let i = 0; i<= 15;i+=1){
    
    for (let x = 0; x <= (img.width*4); x += (48*4)) {
      //console.log("huh")
      let red = imageData[x];
      let green = imageData[x + 1];
      let blue = imageData[x + 2];
      //QUINN PUT CODE HERE
    
      if (red <= green && red <= blue) {
        red /= 2;
    } else if (green <= red && green <= blue) {
        green /= 2;
    } else {
        blue /= 2;
    }
    red = red * brightness;
    green = green * brightness;
    blue = blue * brightness;
      //QUINN'S CODE STOPS HERE
      // Use the RGB values (red, green, blue) here
      //compressedData.push([Math.ceil(red * brightness), Math.ceil(green * brightness), Math.ceil(blue  * brightness)]);
      compressedData.push([Math.floor(red), Math.floor(green), Math.floor(blue)]);
      //console.log(`Pixel ${x / 4}: RGB(${red}, ${green}, ${blue})`);
    }
    //console.log(imageData.slice(img.width*4,imageData.length))
    imageData=imageData.slice(img.width*4*49,imageData.length)
    //console.log(imageData)
  }
  //console.log(compressedData)
  let fixeddata = [];
  for(let i=1;i<=16;i+=1){
    if(i%2==1){
      fixeddata.push(flipList(compressedData.slice(0,16)));
    }else{
      fixeddata.push(compressedData.slice(0,16));
    }
    compressedData = compressedData.slice(16,compressedData.length);
  }
  //console.log(""+fixeddata)
  console.log(""+flipList(fixeddata));
};