povertyIndexList = c("1.0.HCount.2.5usd");
length = 1; 
for(index in povertyIndexList) {
  WDI::WDI(indicator = index, country = c("CZ", "US"), start=1990, end=2020)
}
