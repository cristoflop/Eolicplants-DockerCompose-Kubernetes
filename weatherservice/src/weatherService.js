function GetWeather(call, callback) {

  console.log('Request received: ' + JSON.stringify(call));

  const { city } = call.request;
  const weather = /^[aeiouAEIOU]/.test(city) ? 'Rainy' : 'Sunny';
  const defer = 1000 + Math.random() * 2000;

  setTimeout(() => {
    callback(null, { city, weather });
  }, defer);
}

exports.GetWeather = GetWeather;