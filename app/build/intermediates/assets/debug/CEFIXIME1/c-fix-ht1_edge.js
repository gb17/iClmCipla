/**
 * Adobe Edge: symbol definitions
 */
(function($, Edge, compId){
//images folder
var im='images/';

var fonts = {};
var opts = {
    'gAudioPreloadPreference': 'auto',

    'gVideoPreloadPreference': 'auto'
};
var resources = [
];
var symbols = {
"stage": {
    version: "4.0.0",
    minimumCompatibleVersion: "4.0.0",
    build: "4.0.0.359",
    baseState: "Base State",
    scaleToFit: "width",
    centerStage: "both",
    initialState: "Base State",
    gpuAccelerate: false,
    resizeInstances: false,
    content: {
            dom: [
            {
                id: 'bg2',
                type: 'image',
                rect: ['0', '0','1280px','727px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"bg.jpg",'0px','0px']
            },
            {
                id: 'top_patch_ht1',
                type: 'image',
                rect: ['0', '0','1280px','194px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"top_patch_ht1.png",'0px','0px']
            },
            {
                id: 'taxt_22',
                type: 'image',
                rect: ['205px', '557px','721px','137px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"taxt_2.png",'0px','0px']
            },
            {
                id: 'click1_ht1',
                type: 'image',
                rect: ['71px', '189px','336px','338px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"click1_ht1.png",'0px','0px']
            },
            {
                id: 'click2_ht1',
                type: 'image',
                rect: ['404px', '189px','395px','338px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"click2_ht1.png",'0px','0px']
            },
            {
                id: 'click23_ht1',
                type: 'image',
                rect: ['800px', '189px','367px','338px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"click23_ht1.png",'0px','0px']
            }],
            symbolInstances: [

            ]
        },
    states: {
        "Base State": {
            "${_top_patch_ht1}": [
                ["style", "top", '-20px'],
                ["style", "opacity", '0']
            ],
            "${_click23_ht1}": [
                ["style", "top", '189px'],
                ["style", "opacity", '0'],
                ["style", "left", '900px']
            ],
            "${_click1_ht1}": [
                ["style", "top", '189px'],
                ["style", "opacity", '0'],
                ["style", "left", '200px']
            ],
            "${_click2_ht1}": [
                ["style", "top", '189px'],
                ["style", "opacity", '0'],
                ["style", "left", '500px']
            ],
            "${_Stage}": [
                ["color", "background-color", 'rgba(0,0,0,1.00)'],
                ["style", "width", '1280px'],
                ["style", "height", '727px'],
                ["style", "overflow", 'hidden']
            ],
            "${_taxt_22}": [
                ["style", "top", '580px'],
                ["style", "opacity", '0'],
                ["style", "left", '205px']
            ]
        }
    },
    timelines: {
        "Default Timeline": {
            fromState: "Base State",
            toState: "",
            duration: 1050,
            autoPlay: true,
            timeline: [
                { id: "eid88", tween: [ "style", "${_taxt_22}", "top", '557px', { fromValue: '580px'}], position: 210, duration: 235, easing: "easeOutBounce" },
                { id: "eid106", tween: [ "style", "${_click23_ht1}", "opacity", '1', { fromValue: '0'}], position: 795, duration: 255, easing: "easeOutBounce" },
                { id: "eid81", tween: [ "style", "${_top_patch_ht1}", "top", '0px', { fromValue: '-20px'}], position: 65, duration: 185, easing: "easeOutBounce" },
                { id: "eid86", tween: [ "style", "${_taxt_22}", "opacity", '1', { fromValue: '0'}], position: 210, duration: 235, easing: "easeOutBounce" },
                { id: "eid79", tween: [ "style", "${_top_patch_ht1}", "opacity", '1', { fromValue: '0'}], position: 65, duration: 185, easing: "easeOutBounce" },
                { id: "eid94", tween: [ "style", "${_click1_ht1}", "left", '71px', { fromValue: '200px'}], position: 400, duration: 240, easing: "easeOutBounce" },
                { id: "eid93", tween: [ "style", "${_click1_ht1}", "opacity", '1', { fromValue: '0'}], position: 400, duration: 240, easing: "easeOutBounce" },
                { id: "eid109", tween: [ "style", "${_click23_ht1}", "left", '800px', { fromValue: '900px'}], position: 795, duration: 255, easing: "easeOutBounce" },
                { id: "eid100", tween: [ "style", "${_click2_ht1}", "opacity", '1', { fromValue: '0'}], position: 595, duration: 250, easing: "easeOutBounce" },
                { id: "eid101", tween: [ "style", "${_click2_ht1}", "left", '404px', { fromValue: '500px'}], position: 595, duration: 250, easing: "easeOutBounce" }            ]
        }
    }
}
};


Edge.registerCompositionDefn(compId, symbols, fonts, resources, opts);

/**
 * Adobe Edge DOM Ready Event Handler
 */
$(window).ready(function() {
     Edge.launchComposition(compId);
});
})(jQuery, AdobeEdge, "EDGE-103569781");
