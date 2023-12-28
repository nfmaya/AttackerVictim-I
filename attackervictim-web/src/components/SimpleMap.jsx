import React, {useState} from 'react';
import GoogleMapReact from 'google-map-react';
import './SimpleMap.css'

function SimpleMap({aggresorname='', victimname='', renderPolygons}) {

  const [PositionAggressor, setPositionAggressor] = useState({ lat: 10.487101, lng: -66.830010 });
  const [PositionVictim, setPositionVictim] = useState({ lat: 10.495279, lng: -66.811787 });

  const defaultProps = {
    center: {
      lat: 10.493274,
      lng: -66.822060
    },
    zoom: 15
  };

  const renderMarkers = (map, maps) => {
    // Crea un marcador para el agresor
    let markerAggressor = new maps.Marker({
        icon:{
            path: google.maps.SymbolPath.CIRCLE,
            scale: 8,
            fillColor: "#FF0000",
            fillOpacity: 0.8,
            strokeWeight: 0
        },
        position: PositionAggressor,
        map,
        title: "Agresor"
    });

    const infoWindowaggressor = new maps.InfoWindow({
        content: `Agresor: ${aggresorname}`
    });

    markerAggressor.addListener('click', () => {
        infoWindowaggressor.open(map, markerAggressor);
    });
  
    // Crea un marcador para la víctima
    let markerVictim = new maps.Marker({
        icon:{
            path: google.maps.SymbolPath.CIRCLE,
            scale: 8,
            fillColor: "#24FF00",
            fillOpacity: 0.8,
            strokeWeight: 0
        },
        position: PositionVictim,
        map,
        title: "Víctima"
    });

    const infoWindowvictim = new maps.InfoWindow({
        content: `Victim: ${victimname}`
    });

    markerVictim.addListener('click', () => {
        infoWindowvictim.open(map, markerVictim);
    });
  };

  return (
    // El tamaño del contenedor determina el tamaño del mapa
    <div className='map-simple-style'>
      <GoogleMapReact
        bootstrapURLKeys={{ key: 'AIzaSyCzSi_QDI-Xlc8mMmHFr_Ff7fIV2Kvtiqk' }}
        defaultCenter={defaultProps.center}
        defaultZoom={defaultProps.zoom}
        yesIWantToUseGoogleMapApiInternals
        onGoogleApiLoaded={({ map, maps }) => {
          renderMarkers(map, maps);
          console.log(renderPolygons); // Añade esto para depurar
          if (renderPolygons) {
            renderPolygons(map, maps);
          }
        }}
      />
    </div>
  );
}

export default SimpleMap;