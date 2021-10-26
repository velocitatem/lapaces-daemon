lst <- WDI::WDIsearch("")
for(p in 1:500) {
  indicator <- lst[p,][1]
  print(indicator)
}