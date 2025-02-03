import React, { type FC, type ReactNode } from "react";
import ConvertSelectors from "@state/convert/selector";
import { useSelector } from "react-redux";
import ServiceUtils from "@utils/service-utils";
import styles from "./conversion-results.module.scss"; // deconstruct for shorthand
import cx from "classnames";

// deconstruct for shorthand
const { failed, pending } = ServiceUtils;
const NBSP = "\u00A0";

const ConversionResults: FC = () => {
  const result = useSelector(ConvertSelectors.result);

  let content: ReactNode;
  if (pending(result)) {
    content = NBSP;
  } else if (failed(result)) {
    content = `Error converting number. Enter a new one and try again.`;
  } else {
    content = (
      <div className={styles.result}>
        <div>Roman:</div>
        <div>{result}</div>
      </div>
    );
  }

  return (
    <div
      className={cx(styles.ConversionResults, {
        [styles.error]: result === null,
      })}
    >
      {content}
    </div>
  );
};

export default ConversionResults;
