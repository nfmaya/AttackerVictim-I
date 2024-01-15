import React, { useState } from "react";
import { createContext } from "react";

const UsernameContext = createContext();

function UsernameProvider({ children }) {
  return (
    <UsernameContext.Provider value={this.state}>
      {children}
    </UsernameContext.Provider>
  );
}

export default UsernameProvider;
