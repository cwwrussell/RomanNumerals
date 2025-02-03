# Roman Numeral Converter

## Prerequisites

Before you get started, make sure you have these dependencies installed:

- [Java](https://www.java.com/en/) (this project was written with openjdk-23.0.2 but others may work)
- [Maven](https://maven.apache.org/)
- [nodejs](https://nodejs.org/en) (LTS version recommended)
- [yarn](https://yarnpkg.com/getting-started/install) or npm (included with nodejs)

## Getting Started

### Step 1: Installation

Clone the repository

```shell
git clone git@github.com:cwwrussell/RomanNumerals.git
```

Install server dependencies:

```shell
mvn install
```

Install client dependencies:

```shell
yarn
```

or

```shell
npm install
```

### Step 2: Running the project

To run the java server:

```shell
mvn spring-boot:start
```

To run the react application:

```shell
yarn start
```

Once both the react application and the dev server are running,
navigate to localhost:3000 in your browser.

<img src="assets/romanizer.png" width="450" />

