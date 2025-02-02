import React, { type FC } from "react";
import styles from "./App.module.scss";
import AppTitle from "@components/app-title/app-title";
import ConverterInput from "@components/converter-input/converter-input";
import ConversionResults from "@components/conversion-results/conversion-results";

const App: FC = () => {
  return (
    <div className={styles.App}>
      <div className={styles.appContent}>
        <AppTitle />
        <ConverterInput />
        <ConversionResults />
      </div>
    </div>
  );
};

export default App;
