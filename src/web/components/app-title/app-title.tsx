import React, { type FC } from "react";
import styles from "./app-title.module.scss";

const AppTitle: FC = () => (
  <div className={styles.AppTitle}>
    <div className={styles.title}>Romanizer</div>
    <div className={styles.description}>
      Convert an integer to roman numerals
    </div>
  </div>
);

export default AppTitle;
