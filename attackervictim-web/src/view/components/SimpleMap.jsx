import React, {useState, useRef, useEffect} from 'react';
import GoogleMapReact from 'google-map-react';
import './SimpleMap.css'

function SimpleMap({aggresorname='', victimname='', renderPolygons, onMapLoaded, victimPosition, aggressorPosition, victim_id}) {

  const mapRef = useRef();  // Crear una ref para acceder al mapa
  const mapsRef = useRef(); // Crear una ref para acceder a las utilidades de los mapas

  const aggressorMarkerRef = useRef(null);
  const victimMarkerRef = useRef(null);

  const handleApiLoaded = ({ map, maps }) => {
    mapRef.current = map;
    mapsRef.current = maps;
    /* renderMarkers(map, maps); */
    if (renderPolygons) {
      renderPolygons(map, maps);
    }
    // Llama al callback con las instancias de map y maps
    if (onMapLoaded) {
      onMapLoaded(map, maps);
    }
  };

  const defaultProps = {
    center: {
      lat: 10.493274,
      lng: -66.822060
    },
    zoom: 15
  };

  //cada vez que actualize las posiciones actualiza las marques del mapa
  useEffect(() => {
    if ( mapRef.current && mapsRef.current && victim_id !== 0 ) {
        renderMarkers(mapRef.current, mapsRef.current);

        /* console.log("Posiciones actualizadas victima :" + victimPosition[0] + " " + victimPosition[1]);
        console.log("Posiciones actualizadas Agresor :" + aggressorPosition[0] + " " + aggressorPosition[1]); */
    }
  }, [victimPosition, aggressorPosition]);

  const renderMarkers = (map, maps) => {
    // Elimina el marcador del agresor si ya existe
    if (aggressorMarkerRef.current) {
      aggressorMarkerRef.current.setMap(null);
    }

    // Elimina el marcador de la víctima si ya existe
    if (victimMarkerRef.current) {
      victimMarkerRef.current.setMap(null);
    }

    // Crea un marcador para el agresor y lo guarda en la referencia
    aggressorMarkerRef.current = new maps.Marker({
        icon:{
            path: google.maps.SymbolPath.CIRCLE,
            scale: 8,
            fillColor: "#FF0000",
            fillOpacity: 0.8,
            strokeWeight: 0
        },
        position: { lat: aggressorPosition[0], lng: aggressorPosition[1] },
        map,
        title: "Agresor"
    });

    const infoWindowaggressor = new maps.InfoWindow({
        content: `Agresor: ${aggresorname}`
    });

    aggressorMarkerRef.current.addListener('click', () => {
        infoWindowaggressor.open(map, aggressorMarkerRef.current);
    });
  
    // Crea un marcador para la víctima y lo guarda en la referencia
    victimMarkerRef.current = new maps.Marker({
        icon:{
            path: google.maps.SymbolPath.CIRCLE,
            scale: 8,
            fillColor: "#24FF00",
            fillOpacity: 0.8,
            strokeWeight: 0
        },
        position: { lat: victimPosition[0], lng: victimPosition[1] },
        map,
        title: "Víctima"
    });

    const infoWindowvictim = new maps.InfoWindow({
        content: `Victim: ${victimname}`
    });

    victimMarkerRef.current.addListener('click', () => {
        infoWindowvictim.open(map, victimMarkerRef.current);
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
        onGoogleApiLoaded={handleApiLoaded}
        /* onGoogleApiLoaded={({ map, maps }) => {
          renderMarkers(map, maps);

          if (renderPolygons) {
            renderPolygons(map, maps);
          }
        }} */
      />
    </div>
  );
}

export default SimpleMap;