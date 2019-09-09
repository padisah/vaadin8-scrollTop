# vaadin8-scrollTop
Reproduces a vaadin issue https://github.com/vaadin/framework/issues/11705

Vaadin 8, Window opened with undefined height gets scrolled to the top on each poll

Please not that there is a programming error, which was copied from the source where I discovered the issue. 
Both Push is enabled, and the UI is set up with a polling interval of 10s. I left this as it is, and I 
think that the same problem would be present if push and async would be just disabled, and the polling left enabled. 
