import React, { useState } from 'react'
import './Home.css'
import StateCard from '../components/StateCard'
import SafeZoneBtn from '../components/SafeZoneBtn'
import GeolocationPoint from '../components/GeolocationPoint'
import ComboBox from '../components/ComboBox'
import PlusBtn from '../components/PlusBtn'
import SimpleMap from '../components/SimpleMap'

function Home() {

    const [SafeZoneamount, setSafeZoneamount] = useState(0);
    const [Victim, setVictim] = useState("Alejandro Salas");
    const [Aggressor, setAggressor] = useState("Diego De Queiros");
    const [Distance, setDistance] = useState(15);

    const [geolocationPoints, setGeolocationPoints] = useState([
        { latitude: '', longitude: '' },
        { latitude: '', longitude: '' },
        { latitude: '', longitude: '' },
    ]);

    const addGeolocationPoint = () => {
        setGeolocationPoints([...geolocationPoints, { latitude: '', longitude: '' }]);
    };

    const deleteGeolocationPoint = () => {
        setGeolocationPoints(geolocationPoints.slice(0, -1));
    };

    const updatePoint = (index, lat, lng) => {
        const newPoints = [...geolocationPoints];
        newPoints[index] = { latitude: lat, longitude: lng };
        setGeolocationPoints(newPoints);
    };

    //Calculo de contenedores en relacion a cantidad de puntos de geolocalizacion que renderizar
    const homeHeight = 1450;         // Altura base para el contenedor
    const heightPerPoint = 68;       // Altura por cada GeolocationPoint
    const totalHeight = geolocationPoints.length * heightPerPoint;

    const renderPolygons = (map, maps) => {
        // Define las coordenadas de los polígonos
        const polygons = [
          [
            { lat: 10.493667, lng: -66.822479 },
            { lat: 10.491452, lng: -66.822800 },
            { lat: 10.491241, lng: -66.820504 },
            { lat: 10.493815, lng: -66.821148 },
          ],
          [
            { lat: 10.491790, lng: -66.818852 },
            { lat: 10.490334, lng: -66.814797 },
            { lat: 10.484430, lng: -66.820003 },
          ],
        ];
    
        // Crea y añade los polígonos al mapa
        polygons.forEach((coordinates) => {
          const polygon = new maps.Polygon({
            paths: coordinates,
            strokeColor: '#3581FF',
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: '#3581FF',
            fillOpacity: 0.25,
          });
          polygon.setMap(map);
        });
    };

  return (
    <div className='container-home' style={{height: `${totalHeight + homeHeight}px`}}>

        <div className='title-container-home'>
            <h2 className='title-home'>Case monitoring : </h2>
            <ComboBox/>
            <PlusBtn rute='/Home/NewCase'/>
        </div>

        <div className='map-container'>
            <SimpleMap victimname={Victim} aggresorname={Aggressor} renderPolygons={renderPolygons}/>
        </div>

        <div className='mts-indicator'>
            <p className='description-home'>Current distance between targets</p>
            <p className='mts-number'>{Distance}</p>
        </div>

        <div className='statecards-container'>
            <StateCard Person={Victim}/>
            <StateCard isVictim={false} isConnected={true} Person={Aggressor}/>
        </div>

        <h2 className='subtitle-home'>Safe areas : </h2>

        <div>
            <p className='description-home' style={{marginRight:'650px'}}>Active safe zones : {SafeZoneamount} </p>
            <SafeZoneBtn text='Delete'/>
            <div style={{display:'flex', flexDirection:'row',alignItems:'center'}}>
                <SafeZoneBtn text='Add'/>
                <p className='description-home' style={{marginLeft:'20px'}}>Geolocation points : </p>
            </div>
        </div>

        <div className='geolocation-points-container' style={{marginLeft:'550px', height: `${totalHeight}px`}}>
            {geolocationPoints.map((point, index) => (
                <GeolocationPoint 
                    key={index}
                    isFirstOne={index === 0 && (geolocationPoints.length > 3)}
                    isLastOne={index === geolocationPoints.length - 1}
                    onAdd={addGeolocationPoint}
                    onDelete={deleteGeolocationPoint}
                    latitude={point.latitude}
                    longitude={point.longitude}
                    onUpdate={(lat, lng) => updatePoint(index, lat, lng)}
                />
            ))}
        </div>
    </div>
  )
}

export default Home