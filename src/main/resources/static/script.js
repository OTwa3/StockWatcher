const apiKey = 'e8dbeb09c73ee791ff485f2137ff7e49';

const weatherContainer = document.getElementById("weather");
const city = document.getElementById("city");
const error = document.getElementById("error");

const units = 'metric';
let temperatureSymbol = '°C';

async function fetchWeather() {
    try{
        weatherContainer.innerHTML = '';
        error.innerHTML = '';
        city.innerHTML = '';

        const limit = 1;
        const cityName = document.getElementById("cityName").value;
        const stateCode = document.getElementById("stateCode").value;
        const countryCode = document.getElementById("countryCode").value;


       
       
        
        const geoApiUrl = `https://api.openweathermap.org/geo/1.0/direct?q=${cityName},${stateCode},${countryCode}&limit=${limit}&appid=${apiKey}`;
        const geoResponse = await fetch(geoApiUrl);
        const geoData = await geoResponse.json();

        if (geoData.length === 0) {
            error.innerHTML = "Invalid city name";
            return;
        }

        const location = geoData[0];
        city.innerHTML = `Weather forecast for ${location.name}, ${location.state}, ${location.country}`;


        
        const weatherApiUrl = `https://api.openweathermap.org/data/2.5/weather?lat=${location.lat}&lon=${location.lon}&appid=${apiKey}&units=metric`; 
        const weatherResponse = await fetch(weatherApiUrl);
        const weatherData = await weatherResponse.json();

        console.log(weatherData);
        

         
         displayWeather(weatherData);
        } catch (error) {
            console.error(error);
            error.innerHTML = "An error occurred while fetching weather data.";
        }

        console.log('Fetching city name');

       
        
    }


function displayWeather(weatherData) {
    console.log('Fetching weather description');

    const description = weatherData.weather[0].description;
    const temperature = weatherData.main.temp;
    const humidity = weatherData.main.humidity;
    const windSpeed = weatherData.wind.speed;

    
    const weatherInfo = `
        <p>Description: ${description}</p>
        <p>Temperature: ${temperature} °C</p>
        <p>Humidity: ${humidity}%</p>
        <p>Wind Speed: ${windSpeed} m/s</p>
    `;

    
    weatherContainer.innerHTML = weatherInfo;

        
     }



   
     


   

    

