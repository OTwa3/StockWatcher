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


        //const apiUrl = `http://api.openweathermap.org/geo/1.0/direct?q=${cityName},${stateCode},${countryCode}&limit=${limit}&appid=${apiKey}`;
       
        
        const geoApiUrl = `http://api.openweathermap.org/geo/1.0/direct?q=${cityName},${stateCode},${countryCode}&limit=${limit}&appid=${apiKey}`;
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
        

        // const response = await fetch(apiUrl);
        // const data = await response.json();

        // if (data.length == 0) {
        //     error.innerHTML = "Invalid city name";
        //     return;
        // }

        // const location = data[0];
        // city.innerHTML = `Weather forecast for ${location.name}, ${location.state}, ${location.country}`;

         
         displayWeather(weatherData);
        } catch (error) {
            console.error(error);
            error.innerHTML = "An error occurred while fetching weather data.";
        }

        console.log('Fetching city name');

        // const weatherDescription = createWeatherDescription(data);
        // weatherContainer.appendChild(weatherDescription);

        
    }


        // catch (error) {
        //     console.log(error);
    
        //  }


        // }

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

    
    // const temperature = weatherData.main.temp;
    // const description = weatherData.weather[0].description;

    
    // const descriptionDiv = document.createElement('div');

    // descriptionDiv.innerHTML = `
    //     <div class="weather-description">
    //         <p>Temperature: ${temperature}${temperatureSymbol}</p>
    //         <p>Description: ${description}</p>
    //     </div>
    // `;

    // return descriptionDiv;
        
     }

    //     data.list.array.forEach(data => {
    //         const weatherdata = createWeatherDescription(data);
    //         weatherContainer.appendChild(weatherdata);
    //     });

        
    // }

   
     


    // function ConvertToLocalTime(dt){
    //     const date = new Date(dt * 1000);

    //     const year = date.getFullYear();
    //     const month = String(date.getMonth() + 1).padStart(2, '0');
    //     const day = String(date.getDate()).padStart(2, '0');
    //     const hours = String(date.getHours() % 12 || 12).padStart(2, '0');
    //     const minutes = String(date.getMinutes()).padStart(2, '0');
    //     const seconds = String(date.getSeconds()).padStart(2, '0');
    //     const period = date.getHours() >= 12 ? 'PM' : 'AM';

    //     return `${year}-${month}-${day} ${hours}:${minutes}:${seconds} ${period}`;


    // }

   

    

